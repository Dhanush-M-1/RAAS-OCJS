#include <bits/stdc++.h>
using namespace std;
void vin(vector<int>& v) {
  int i, p;
  int n = (int)v.size();
  for (i = 0; i < n; i++) {
    scanf("%d", &v[i]);
  }
}
void vin(vector<long long>& v) {
  long long i, p;
  int n = v.size();
  for (i = 0; i < n; i++) {
    scanf("%lld", &v[i]);
  }
}
void vout(const vector<int>& v) {
  for (auto q : v) printf("%d ", q);
  printf("\n");
}
void vout(const vector<long long>& v) {
  for (auto q : v) printf("%lld ", q);
  printf("\n");
}
struct typ {
  int tp = -1;
  long long a = 0, b = 0;
};
struct comp {
  bool operator()(typ const& a, typ const& b) { return a.a < b.a; }
};
int main(int argc, char const* argv[]) {
  int t = 1;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<string> v(n);
    int i;
    for (i = 0; i < n; i++) cin >> v[i];
    bool ans = 0;
    int a, b, c, d;
    a = v[0][1] - '0';
    b = v[1][0] - '0';
    c = v[n - 1][n - 2] - '0';
    d = v[n - 2][n - 1] - '0';
    vector<pair<int, int>> out;
    if (a == b && b == c && c == d) {
      out.push_back({1, 2});
      out.push_back({2, 1});
    } else {
      if (a == b) {
        if (c != d) {
          if (c == a)
            out.push_back({n, n - 1});
          else
            out.push_back({n - 1, n});
        }
      } else if (c == d) {
        if (a == c) {
          out.push_back({1, 2});
        } else {
          out.push_back({2, 1});
        }
      } else {
        if (a == c) {
          out.push_back({1, 2});
          out.push_back({n - 1, n});
        } else {
          out.push_back({1, 2});
          out.push_back({n, n - 1});
        }
      }
    }
    printf("%d\n", (int)out.size());
    for (auto q : out) printf("%d %d\n", q.first, q.second);
  }
  return 0;
}
