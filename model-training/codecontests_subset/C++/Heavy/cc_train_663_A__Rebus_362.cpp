#include <bits/stdc++.h>
using namespace std;
int main() {
  char c;
  int plus, minus, n, extra = 0;
  vector<int> seq(1, 1);
  while (1) {
    cin >> c;
    if (c == '+')
      seq.push_back(1);
    else if (c == '-')
      seq.push_back(-1);
    else if (c == '=')
      break;
  }
  cin >> n;
  plus = count(seq.begin(), seq.end(), 1);
  minus = count(seq.begin(), seq.end(), -1);
  vector<int> ans(seq.size(), 1);
  if (n < (plus - minus * n) || n > (plus * n - minus))
    cout << "Impossible\n";
  else {
    cout << "Possible\n";
    extra = plus - minus - n;
    for (int i = 0; i < seq.size(); i++) {
      if (extra == 0)
        break;
      else {
        extra = extra - seq[i] * ans[i];
        if (extra * seq[i] > 0)
          ans[i] = max(1, min(n, -seq[i] * extra));
        else
          ans[i] = min(n, max(1, -seq[i] * extra));
        extra = extra + seq[i] * ans[i];
      }
    }
    cout << ans[0];
    for (int i = 1; i < seq.size(); i++)
      cout << (seq[i] == 1 ? " +" : " -") << " " << ans[i];
    cout << " = " << n;
  }
  return 0;
}
