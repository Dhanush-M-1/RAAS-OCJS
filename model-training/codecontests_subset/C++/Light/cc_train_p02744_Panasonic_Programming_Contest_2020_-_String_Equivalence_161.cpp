#include <bits/stdc++.h>
using namespace std;
int N;

void dfs(string s, char c)
{
  if (s.size() == N)
  {
    cout << s << endl;
  }
  else
  {
    for (char i = 'a'; i <= c; i++)
    {
      if (i != c)
        dfs(s + i, c);
      else
        dfs(s + i, c + 1);
    }
  }
}

int main()
{
  cin >> N;
  dfs("", 'a');
}
