var n = +readline(),
    x = [],
    h = [],
    count = (n === 1) ? 1 : 2;

for (var i = 0; i < n; i ++)
{
  var line = readline().split(' ');
  x[i] = +line[0],
  h[i] = +line[1];
}

for (var i = 1; i < n - 1; i ++)
{
  if (x[i - 1] < x[i] - h[i])
  {
    count ++;
  }
  else if (x[i + 1] > x[i] + h[i])
  {
    x[i] += h[i];
    count ++;
  }
}

print(count);
