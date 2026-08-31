#include <bits/stdc++.h>
using namespace std;
constexpr int N = 2 * ((int)3e6 + 10);
long long p[N], n;
int d[N + N];
long long cnt_left, cnt_right;
long long add_left, add_right;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> p[i];
  int mid = N / 2;
  long long cur_ans = 0;
  int step = 0;
  for (int i = 1; i <= n; ++i) {
    d[mid + p[i] - i]++;
    if (p[i] < i)
      cnt_left++, add_left += i - p[i];
    else if (p[i] > i)
      cnt_right++, add_right += p[i] - i;
    cur_ans += abs(p[i] - i);
  }
  for (int i = 1; i <= n; ++i) {
    d[mid + p[i] - 1]--;
    if (p[i] > 1) {
      cnt_right--;
      add_right -= p[i] - 1;
    } else if (p[i] < 1) {
      cnt_left--;
      add_left -= 1 - p[i];
    }
    cnt_right += d[mid];
    add_right += cnt_right;
    add_left -= cnt_left;
    cnt_left -= d[mid - 1];
    mid--;
    d[mid + p[i] - n]++;
    if (p[i] < n)
      cnt_left++, add_left += n - p[i];
    else if (p[i] > n)
      cnt_right++, add_right += p[i] - n;
    if (cur_ans > add_left + add_right) {
      cur_ans = add_left + add_right;
      step = n - i;
    }
  }
  cout << cur_ans << " " << step << endl;
  return 0;
}
