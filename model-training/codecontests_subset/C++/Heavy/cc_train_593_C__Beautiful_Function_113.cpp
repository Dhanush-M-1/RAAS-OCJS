#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
const int MAXN = 55;
string add(string s, string t) { return "(" + s + "+" + t + ")"; }
string subtr(string s, string t) { return "(" + s + "-" + t + ")"; }
string mult(string s, string t) { return "(" + s + "*" + t + ")"; }
string abs(string s) { return "abs(" + s + ")"; }
string get0(int x) {
  stringstream ss;
  ss << x;
  return ss.str();
}
string get(int x) { return x > 50 ? add("50", get(x - 50)) : get0(x); }
int N;
int X[MAXN], Y[MAXN];
string solve(int *arr) {
  string ans = "0";
  for (int i = 1; i <= N; i++) {
    int val = arr[i];
    string expr = subtr("t", get(i - 1));
    expr = add(abs(expr), expr);
    expr = mult(get(abs(val) / 2), expr);
    if (val >= 0) {
      ans = add(ans, expr);
    } else {
      ans = subtr(ans, expr);
    }
    for (int j = i; j <= N; j++) {
      arr[j] -= (j - i + 1) * val;
    }
  }
  return ans;
}
int main() {
  if (fopen("input.txt", "r")) {
    freopen("input.txt", "r", stdin);
  }
  cin >> N;
  for (int i = 1, tmp; i <= N; i++) {
    cin >> X[i] >> Y[i] >> tmp;
    X[i] -= X[i] % 2;
    Y[i] -= Y[i] % 2;
  }
  cout << solve(X) << endl << solve(Y) << endl;
}
