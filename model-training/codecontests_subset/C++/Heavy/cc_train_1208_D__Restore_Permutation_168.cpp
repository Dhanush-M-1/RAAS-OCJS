#include <bits/stdc++.h>
using namespace std;
struct S {
  int a, b;
  S() {}
  S(int _a, int _b) {
    a = _a;
    b = _b;
  }
  const bool operator<(const S &o) const { return a < o.a; }
};
string exm;
inline void exf(void) {
  cout << exm << "\n";
  exit(0);
}
template <typename T>
inline void showAll(vector<T> &v, string sep = "") {
  for (T &here : v) cout << here << sep;
}
template <typename T>
inline void showAll(T arr[], int st, int end, string sep = "") {
  for (int i = st; i <= end; i++) cout << arr[i] << sep;
}
template <typename T>
inline vector<int> int_seperation(T N, int d = 10) {
  vector<int> v;
  while (N) {
    v.push_back(N % d);
    N /= d;
  }
  reverse(v.begin(), v.end());
  return v;
}
const int SIZE = 200009;
long long arr[SIZE], tree[SIZE * 8];
int ans[SIZE];
int n;
long long getSum(int i) {
  long long res = 0;
  while (i) {
    res += tree[i];
    i -= (i & -i);
  }
  return res;
}
void update(int i, long long a) {
  while (i < n + 1) {
    tree[i] += a;
    i += (i & -i);
  }
  return;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &arr[i]);
  }
  for (int i = 1; i <= n; i++) {
    update(i, i);
  }
  for (int i = n; i; i--) {
    int l = 0, r = n + 1;
    while (l + 1 < r) {
      int mid = (l + r) / 2;
      long long sum = getSum(mid) - getSum(0);
      if (sum > arr[i])
        r = mid;
      else
        l = mid;
    }
    ans[i] = l + 1;
    update(l + 1, -l - 1);
  }
  showAll(ans, 1, n, " ");
  return 0;
}
