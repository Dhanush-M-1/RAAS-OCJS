var ln = +readline();
var str = readline();

var one = str.match(/1/g) || [];
var zero = str.match(/0/g) || [];

if (one.length === zero.length) {
  write(String(2) + '\n');
  write(`${str.slice(0, -1)} ${str[ln-1]}`);
} else {
  write(String(1) + '\n');
  write(str);
}