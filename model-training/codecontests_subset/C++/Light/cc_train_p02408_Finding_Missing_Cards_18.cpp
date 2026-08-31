#include <bits/stdc++.h>
int a[4][14];
int main()
{
  int n, b;
  char c;
  char s[] = "SHCD";
  std::cin >> n;
  for (int i = 0; i < n; i++)
  {
    std::cin >> c >> b;
    if (c == 'S')
      a[0][b]++;
    else if (c == 'H')
      a[1][b]++;
    else if (c == 'C')
      a[2][b]++;
    else
      a[3][b]++;
  }
  for (int i = 0; i < 4; i++)
  {
    for (int j = 1; j <= 13; j++)
    {
      if (!a[i][j])
      {
        std::cout << s[i] << " " << j << std::endl;
      }
    }
  }
}

