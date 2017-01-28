/**
 * 
 */
function processData(input) {
    var arr = input.split('\n');
    arr.shift();
    var stackAnalyse = function(stack , ch){
        var top = stack[stack.length - 1 ];
        switch(ch){
            case '{':
            case '(':
            case '[':
                stack.push(ch);
                break;
            case '}':
                if( top === '{' ){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
                break;
            case ')':
                if( top === '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
                break;
            case ']':
                if( top === '['){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
                break;
        }
        return stack;
    };
    arr.forEach(function(x){
       var stack = [];
       for(var i = 0 ; i < x.length ; i++){
           stack = stackAnalyse(stack , x[i]);
       }
       if(stack.length === 0){
           console.log('YES');
       }else{
           console.log('NO');
       }
    });
}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});
