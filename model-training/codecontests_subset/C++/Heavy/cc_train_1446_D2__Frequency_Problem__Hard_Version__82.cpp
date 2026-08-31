#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
const int MAX = 500;
int solve(int N, const deque<int>& A) {
  vector<int> hist(N, 0);
  for (int i = 0; i < N; ++i) hist[A[i]]++;
  vector<int> mean(N, 0);
  iota(mean.begin(), mean.end(), 0);
  sort(mean.begin(), mean.end(),
       [&](int i, int j) { return hist[i] > hist[j]; });
  if (hist[mean[0]] == N) return 0;
  int res = 2;
  for (int id = 1; id < min(MAX, N); ++id) {
    int v = mean[id];
    int GETA = A.size(), meannum = 0, vnum = 0;
    vector<int> vmin(GETA * 2 + 1, GETA), vmax(GETA * 2 + 1, -1);
    vmin[GETA] = vmax[GETA] = 0;
    for (int i = 0; i < N; ++i) {
      if (A[i] == mean[0])
        ++meannum;
      else if (A[i] == v)
        ++vnum;
      chmin(vmin[meannum - vnum + GETA], i + 1);
      chmax(vmax[meannum - vnum + GETA], i + 1);
    }
    for (int i = 0; i < vmin.size(); ++i) chmax(res, vmax[i] - vmin[i]);
  }
  for (int k = hist[min(MAX, N) - 1]; k >= 1; --k) {
    int left = 0, vmax = 0, num = 0, num2 = 0;
    hist.assign(N, 0);
    auto push = [&](int id) -> void {
      hist[A[id]]++;
      chmax(vmax, hist[A[id]]);
      if (hist[A[id]] == k)
        ++num;
      else if (hist[A[id]] > k)
        --num, ++num2;
    };
    auto pop = [&](int id) -> void {
      hist[A[id]]--;
      if (hist[A[id]] == k)
        ++num, --num2;
      else if (hist[A[id]] == k - 1)
        --num;
      if (num2 == 0 && num > 0)
        vmax = k;
      else if (num2 == 0 && num == 0)
        vmax = k - 1;
    };
    for (int right = 1; right <= N; ++right) {
      push(right - 1);
      while (left < right && vmax > k) pop(left++);
      if (num >= 2) chmax(res, right - left);
    }
  }
  return res;
}
int main() {
  int N;
  scanf("%d", &N);
  deque<int> A(N);
  for (int i = 0; i < N; ++i) scanf("%d", &A[i]), --A[i];
  printf("%d\n", solve(N, A));
}
