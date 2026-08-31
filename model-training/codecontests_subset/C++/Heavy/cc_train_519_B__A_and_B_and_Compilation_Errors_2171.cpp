#include <bits/stdc++.h>
using namespace std;
bool cmp(int a, int b) { return a > b; }
template <class T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
template <class T>
T lcm(T a, T b) {
  return a * b / gcd(a, b);
}
int n;
vector<int> vv, vv1, vv2;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  long long tt;
  for (int i = 0; i < n; i++) {
    cin >> tt;
    vv.push_back(tt);
  }
  sort(vv.begin(), vv.end());
  for (int i = 0; i < n - 1; i++) {
    cin >> tt;
    vv1.push_back(tt);
  }
  vv1.push_back(1000000005);
  sort(vv1.begin(), vv1.end());
  for (int i = 0; i < n - 2; i++) {
    cin >> tt;
    vv2.push_back(tt);
  }
  vv2.push_back(1000000005);
  vv1.push_back(1000000006);
  sort(vv2.begin(), vv2.end());
  for (int i = 0; i < n; i++) {
    if (vv[i] == vv1[i]) {
    } else {
      cout << vv[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (vv2[i] == vv1[i]) {
    } else {
      cout << vv1[i] << endl;
      break;
    }
  }
  return 0;
}
