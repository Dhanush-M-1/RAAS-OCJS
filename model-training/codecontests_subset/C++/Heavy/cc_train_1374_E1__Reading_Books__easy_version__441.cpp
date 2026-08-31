#include <bits/stdc++.h>
using namespace std;
struct cmp {
  bool operator()(const long long &a, const long long &b) { return a >= b; }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, k;
  cin >> n >> k;
  long long first = 0, second = 0, ans = 0;
  long long temp1 = 0, temp2 = 0, temp3 = 0;
  priority_queue<long long, vector<long long>, cmp> a;
  priority_queue<long long, vector<long long>, cmp> b;
  priority_queue<long long, vector<long long>, cmp> c;
  for (int i = 0; i < n; i++) {
    cin >> temp1 >> temp2 >> temp3;
    if (temp2 != 0 && temp3 == 0)
      a.push(temp1);
    else if (temp2 == 0 && temp3 != 0)
      b.push(temp1);
    else if (temp2 == 1 && temp3 == 1)
      c.push(temp1);
  }
  if (a.size() + c.size() < k || b.size() + c.size() < k) {
    cout << -1;
    return 0;
  }
  long long ran = min(a.size(), b.size());
  while (ran--) {
    c.push(a.top() + b.top());
    a.pop();
    b.pop();
  }
  while (k--) {
    ans += c.top();
    c.pop();
  }
  cout << ans;
  return 0;
}
