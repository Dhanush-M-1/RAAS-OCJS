readline();
str = readline();

res = [];
word = "";
function addWord() {
    var ch = word.charAt(0);
    if ((ch == 'e' || ch == 'o') && word.length <= 2) {
        res.push(word);
    } else if (['e', 'a', 'i', 'o', 'u', 'y'].indexOf(ch) !== -1) {
        res.push(ch);
    } else {
        res.push(word);
    }
    word = '';
}
for (var i = 0; i < str.length; i++) {
    if (word == '' || word[0] === str[i]) {
        word += str[i];
    } else {
        addWord();
        word = str[i];
    }
}
addWord();


write(res.join(''));