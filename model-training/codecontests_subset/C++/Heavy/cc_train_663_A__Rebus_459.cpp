#include <bits/stdc++.h>
using namespace std;
const long long INF = (long long)LLONG_MAX;
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};
int dx8[9] = {1, 0, -1, 0, 1, -1, -1, 1, 0};
int dy8[9] = {0, 1, 0, -1, 1, -1, 1, -1, 0};
long long ipow(long long base, long long exp) {
  long long result = 1;
  while (exp) {
    if (exp & 1) result *= base;
    exp >>= 1;
    base *= base;
  }
  return result;
}
string tos(long long n) {
  stringstream ss;
  string ans;
  ss << n;
  ss >> ans;
  return ans;
}
long long toll(string n) { return atoll(n.c_str()); }
double dist(double x1, double y1, double x2, double y2) {
  return sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
}
int doubleCompare(double x, double y) {
  if (fabs(x - y) <= 1e-18) return 0;
  if (x < y) return -1;
  return 1;
}
int main() {
  vector<long long> ans;
  char tmp;
  long long ret = 1;
  while (1) {
    cin >> tmp;
    if (tmp == '=') break;
    if (tmp == '-') {
      ret--;
      ans.push_back(-1);
    } else if (tmp == '+') {
      ret++;
      ans.push_back(-2);
    } else {
      ans.push_back(1);
    }
  }
  long long n;
  cin >> n;
  for (int i = ans.size() - 1; i >= 0; i -= 2) {
    if (ret == n) break;
    if (i == 0) {
      while (ret < n && ans[i] < n) {
        ret++;
        ans[i]++;
      }
    } else {
      while (ret > n && ans[i - 1] == -1 && ans[i] < n) {
        ret--;
        ans[i]++;
      }
      while (ret < n && ans[i - 1] == -2 && ans[i] < n) {
        ret++;
        ans[i]++;
      }
    }
  }
  if (ret == n) {
    cout << "Possible\n";
    for (int i = 0; i < ans.size(); i++) {
      if (ans[i] == -1)
        cout << " - ";
      else if (ans[i] == -2)
        cout << " + ";
      else
        cout << ans[i];
    }
    cout << " = " << n;
  } else {
    cout << "Impossible";
  }
}
