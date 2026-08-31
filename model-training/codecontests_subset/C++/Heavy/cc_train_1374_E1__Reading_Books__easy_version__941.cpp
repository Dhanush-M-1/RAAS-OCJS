#include <bits/stdc++.h>
using namespace std;
int reading_books(int n, int k, vector<int>& t, vector<int>& a,
                  vector<int>& b) {
  int cnt_a, cnt_b, total;
  vector<int> av, bv, cv;
  total = 0;
  cnt_a = cnt_b = k;
  auto choose_alice = [&]() {
    total += av.back();
    cnt_a = max(0, cnt_a - 1);
    av.pop_back();
  };
  auto choose_bob = [&]() {
    total += bv.back();
    cnt_b = max(0, cnt_b - 1);
    bv.pop_back();
  };
  auto choose_common = [&]() {
    total += cv.back();
    cnt_a = max(0, cnt_a - 1);
    cnt_b = max(0, cnt_b - 1);
    cv.pop_back();
  };
  for (int i = 0; i < n; i++) {
    if (a[i] && b[i])
      cv.push_back(t[i]);
    else if (a[i])
      av.push_back(t[i]);
    else if (b[i])
      bv.push_back(t[i]);
  }
  if (av.size() + cv.size() < k || bv.size() + cv.size() < k) return -1;
  sort(av.rbegin(), av.rend());
  sort(bv.rbegin(), bv.rend());
  sort(cv.rbegin(), cv.rend());
  while (cnt_a || cnt_b) {
    if (cnt_a && cnt_b) {
      if (av.empty() || bv.empty() ||
          (!cv.empty() && av.back() + bv.back() >= cv.back()))
        choose_common();
      else {
        choose_alice();
        choose_bob();
      }
    } else if (cnt_a) {
      if (av.empty() || (!cv.empty() && av.back() >= cv.back()))
        choose_common();
      else
        choose_alice();
    } else {
      if (bv.empty() || (!cv.empty() && bv.back() >= cv.back()))
        choose_common();
      else
        choose_bob();
    }
  }
  return total;
}
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> t(n), a(n), b(n);
  for (int i = 0; i < n; i++) cin >> t[i] >> a[i] >> b[i];
  cout << reading_books(n, k, t, a, b);
  return 0;
}
