#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const double PI = acos(-1);
bool type[110];
int ans[110];
int n;
string S;
int main() {
  type[0] = true;
  int cnt = 1;
  int pe = 1, ne = 0;
  cin >> S;
  while (cin >> S) {
    if (S[0] == '=') break;
    if (S[0] == '+') {
      type[cnt] = true;
      pe++;
    } else {
      type[cnt] = false;
      ne++;
    }
    cnt++;
    cin >> S;
  }
  cin >> n;
  int ma = pe * n - ne;
  int mi = pe - ne * n;
  int sum = n;
  if (n > ma || n < mi) {
    cout << "Impossible" << endl;
    return 0;
  } else {
    for (int i = 0; i < cnt; i++) {
      ans[i] = 1;
      if (type[i])
        n--;
      else
        n++;
    }
    for (int i = 0; i < cnt; i++) {
      if (n == 0) break;
      if (n < 0 && type[i] == false) {
        int t = sum - 1;
        ans[i] += min(t, -n);
        n += min(t, -n);
      }
      if (n > 0 && type[i] == true) {
        int t = sum - 1;
        ans[i] += min(t, n);
        n -= min(t, n);
      }
    }
    cout << "Possible" << endl;
    cout << ans[0] << " ";
    for (int i = 1; i < cnt; i++) {
      if (type[i])
        cout << "+ ";
      else
        cout << "- ";
      cout << ans[i] << " ";
    }
    cout << "= " << sum << endl;
  }
  return 0;
}
