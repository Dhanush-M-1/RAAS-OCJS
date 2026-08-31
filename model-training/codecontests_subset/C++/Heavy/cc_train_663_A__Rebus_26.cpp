#include <bits/stdc++.h>
using namespace std;
string s;
long long int n, add = 1, sub;
vector<char> ops;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  getline(cin, s);
  ops.push_back('+');
  for (long long int i = 0; i < (long long int)s.length(); ++i) {
    if (s[i] == ' ' || s[i] == '?' || s[i] == '=') continue;
    if (isdigit(s[i])) {
      n = (n * 10) + (s[i] - '0');
      continue;
    }
    if (s[i] == '+')
      add++;
    else
      sub++;
    ops.push_back(s[i]);
  }
  long long int maxnet = n * add - sub, minet = add - n * sub;
  if (n > maxnet || n < minet) {
    cout << "Impossible\n";
    return 0;
  }
  vector<long long int> res;
  long long int cur = 0;
  for (long long int i = 0; i < (long long int)ops.size(); ++i) {
    if (ops[i] == '+')
      add--;
    else
      sub--;
    long long int dir = ((ops[i] == '+') ? 1 : -1);
    for (long long int j = 1; j <= n; ++j) {
      long long int maxn = cur + (j * dir) + add * n - sub,
                    minn = cur + (j * dir) + add - sub * n;
      if (minn <= n && n <= maxn) {
        res.push_back(j);
        cur += dir * j;
        break;
      }
    }
  }
  cout << "Possible\n";
  for (long long int i = 0; i < (long long int)res.size(); ++i) {
    cout << res[i] << ' ';
    if (i < (long long int)ops.size() - 1) cout << ops[i + 1] << ' ';
  }
  cout << "= ";
  cout << n << '\n';
  return 0;
}
