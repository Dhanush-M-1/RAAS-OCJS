#include <bits/stdc++.h>
using namespace std;
const long double EPS = 1e-10;
const long long MOD = 1000000007ll;
const long long mod1 = 1000000009ll;
const long long mod2 = 1100000009ll;
int INF = (int)1e9 + 5;
long long INFINF = (long long)1e18;
int sign[200];
int main() {
  string s;
  getline(cin, s);
  int plus, minus;
  int k = 0;
  plus = 1;
  minus = 0;
  int l = s.length();
  int num = 0;
  for (int i = 0; i < l; i++) {
    if (s[i] == '+') {
      plus++;
      sign[k++] = 1;
    } else if (s[i] == '-') {
      minus++;
      sign[k++] = -1;
    }
    if (s[i] == '=') {
      for (int j = i + 2; j <= l - 1; j++) num = num * 10 + (s[j] - '0');
      break;
    }
  }
  if (plus - num * minus > num || plus * num - minus < num) {
    cout << "Impossible" << endl;
    return 0;
  }
  cout << "Possible" << endl;
  int till_sum = 0;
  for (int i = 0; i < k; i++) {
    int sig = 1;
    if (i > 0) sig = sign[i - 1];
    if (sig == 1)
      plus--;
    else
      minus--;
    for (int j = 1; j <= num; j++) {
      if (till_sum + j * sig + plus - num * minus <= num &&
          till_sum + j * sig + num * plus - minus >= num) {
        cout << j << " " << (sign[i] == 1 ? '+' : '-') << " ";
        till_sum += j * sig;
        break;
      }
    }
  }
  cout << abs(num - till_sum) << " = " << num << endl;
  return 0;
}
