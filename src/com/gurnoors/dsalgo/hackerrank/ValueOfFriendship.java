package com.gurnoors.dsalgo.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Hackerrank week of code 28 ( check email around Jan 9)
 * Proble,: value of friendship
 * @author gurnoorsinghbhatia
 *
 */
public class ValueOfFriendship {
	public class Student {
		int id;
		List<Student> friends = new ArrayList<>();
		List<Student> directFriends = new ArrayList<>();

		private Set<Student> tempVisited = new HashSet<>();

		@Override
		public boolean equals(Object obj) {
			return this.id == ((ValueOfFriendship.Student) obj).id;
		}

		public void addFriend(Student friend) {
			tempVisited = new HashSet<Student>();
			addRecursively(friend);
		}

		private void addRecursively(Student friend) {
			if (!tempVisited.contains(friend)) {
				tempVisited.add(friend);
				this.friends.add(friend);
				for (Student fof : friend.friends) {
					addRecursively(fof);
				}
			}
		}

	}

	public class Friendship {
		public Friendship(Student studentX, Student studentY) {
			this.x = studentX;
			this.y = studentY;
		}

		Student x;
		Student y;
	}

	public class SetBySizeComparator implements Comparator<Set<Student>> {

		@Override
		public int compare(Set<Student> o1, Set<Student> o2) {
			return o1.size() > o2.size() ? -1 
					: o1.size() < o2.size() ? 1 
					: 0;
		}

	}

	public static void main(String[] args) {
		ValueOfFriendship s = new ValueOfFriendship();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Set<Student> college = new HashSet<>();
		List<Friendship> friendships = new ArrayList<>();
		int maxTotal = 0;
		int total = 0;
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			for (int a1 = 0; a1 < m; a1++) {
				int x = in.nextInt();
				int y = in.nextInt();
				// your code goes here

				Student studentX = s.new Student();
				studentX.id = x;
				Student studentY = s.new Student();
				studentY.id = y;
				studentX.addFriend(studentY);
				studentX.directFriends.add(studentY);
				studentY.directFriends.add(studentX);
				studentY.addFriend(studentX);
				college.add(studentX);
				college.add(studentY);
				friendships.add(s.new Friendship(studentX, studentY));
				// total = updateTotal(college);
			}
		}

		// ordered desc by no of nodes
		List<Set<Student>> subgraphs = subgraphs(college);
		// maxTotal = findMax_brute(friendships, s);
		maxTotal = findMax(friendships, s, subgraphs);
		System.out.println(maxTotal);

	}

	private static List<Set<Student>> subgraphs(Set<Student> college) {
		List<Set<Student>> subgraphs = new ArrayList<>();
		Set<Student> visited = new HashSet<>();

		for (Student student : college) {
			if (visited.add(student)) {
				Set<Student> toRet = new HashSet<>();
				// traverse this subgraph, poulate visited, return the subgraph
				subgraphs.add(traverse(student, visited, toRet));
			}
		}
		ValueOfFriendship tempS = new ValueOfFriendship();
		Collections.sort(subgraphs, tempS.new SetBySizeComparator());

		return subgraphs;
	}

	/**
	 * 
	 * @param student
	 * @param visited
	 * @return toRet the subgraph traversed
	 */
	private static Set<Student> traverse(Student student, Set<Student> visited, Set<Student> toRet) {
		if (visited.add(student)) {
			toRet.add(student);
			for (Student friend : student.directFriends) {
				traverse(friend, visited, toRet);
			}
		}
		return toRet;
	}

	/**
	 * nextEdge() picks up the friendship(s) present in the largest subgraph. If
	 * there are multiple, then it picks the one which expands the subgraph we
	 * are currently building, instead of building a separate subgraph. If the
	 * above are not found, pick any friendship.
	 * 
	 * Maybe we need to check starting from every friendship (currently we are
	 * starting from any one in largest subgraph).
	 * 
	 * @param friendships
	 * @param s
	 * @param subgraphs 
	 * @return
	 */
	private static int findMax(List<Friendship> friendships, ValueOfFriendship s, List<Set<Student>> subgraphs) {
		int maxTotal = 0;
		
		return 0;
	}

	/**
	 * Unused
	 * 
	 * @param friendships
	 * @param s
	 * @return
	 */
	private static int findMax_brute(List<Friendship> friendships, ValueOfFriendship s) {
		int maxTotal = 0;

		for (List<Friendship> orderi : permutations(friendships)) {
			Set<Student> college = new HashSet<>();
			for (Friendship friendship : orderi) {
				Student studentX = friendship.x;
				Student studentY = friendship.y;
				studentX.addFriend(studentY);
				studentY.addFriend(studentX);
				college.add(studentX);
				college.add(studentY);
			}
			int total = updateTotal(college);
			if (total > maxTotal) {
				maxTotal = total;
			}
		}
		return maxTotal;
	}

	/**
	 * Unused
	 * 
	 * @param friendships
	 * @return
	 */
	private static List<List<Friendship>> permutations(List<Friendship> friendships) {
		List<List<Friendship>> perms = new ArrayList<List<Friendship>>();
		int permsCount = factorial(friendships.size());

		return null;
	}

	private static int factorial(int size) {
		if (size == 1) {
			return 1;
		} else {
			return size * factorial(size - 1);
		}
	}

	private static int updateTotal(Set<Student> college) {
		int total = 0;
		for (Student student : college) {
			total += student.friends.size();
		}
		return total;
	}

}
