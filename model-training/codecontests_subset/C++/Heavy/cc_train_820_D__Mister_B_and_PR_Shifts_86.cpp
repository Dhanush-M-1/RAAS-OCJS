#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const long long linf = 1e18 + 7;
const int inf = 1e9 + 7;
const int N = 1e6 + 5;
int n, a[N], cnt, pc, mc;
long long ans = linf, ans_p, cur;
deque<int> dq;
set<pair<int, int> > st;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    int x = i - a[i];
    if (x >= 0) {
      cur += x;
      pc++;
    } else {
      cur -= x;
      mc++;
      st.insert(make_pair(-x, i));
    }
    dq.push_back(x);
  }
  for (int i = n; i >= 1; i--) {
    if (cur < ans) {
      ans = cur;
      ans_p = n - i;
    }
    int x = dq.back();
    if (x + cnt >= 0) {
      cur -= x + cnt;
      pc--;
    } else {
      cur += x + cnt;
      mc--;
    }
    dq.pop_back();
    cur += pc;
    cur -= mc;
    cnt++;
    x = 1 - a[i] - cnt;
    if (x + cnt >= 0) {
      cur += x + cnt;
      pc++;
    } else {
      cur -= x + cnt;
      mc++;
      st.insert(make_pair(-x, i + n));
    }
    dq.push_front(x);
    while (!st.empty()) {
      pair<int, int> pr = *st.begin();
      pr.first *= -1;
      if (pr.first + cnt >= 0) {
        cur += pr.first + cnt;
        pc++;
        mc--;
        st.erase(st.begin());
      } else
        break;
    }
  }
  cout << ans << " " << ans_p << endl;
}
