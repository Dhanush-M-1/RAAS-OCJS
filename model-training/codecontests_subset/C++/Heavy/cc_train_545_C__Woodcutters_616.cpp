#include <bits/stdc++.h>
using namespace std;
int main() {
  long n;
  cin >> n;
  vector<pair<long, long>> a;
  long x, h;
  a.emplace_back(0, 0);
  for (int i = 0; i < n; i++) {
    cin >> x >> h;
    a.emplace_back(x, h);
  }
  sort(a.begin(), a.end());
  vector<pair<long, long>> cut_left(n + 1);
  vector<pair<long, long>> cut_right(n + 1);
  vector<pair<long, long>> not_cut(n + 1);
  cut_left[0] = {0, -1e9};
  cut_right[0] = {0, -1e9};
  not_cut[0] = {0, -1e9};
  for (int i = 1; i < n; i++) {
    x = a[i].first;
    h = a[i].second;
    long lastep, lastc;
    lastc = cut_left[i - 1].first;
    lastep = cut_left[i - 1].second;
    if (lastep < x - h) {
      cut_left[i] = {lastc + 1, x};
    } else {
      cut_left[i] = {0, x};
    }
    lastc = cut_right[i - 1].first;
    lastep = cut_right[i - 1].second;
    if (lastep < x - h) {
      if (lastc + 1 > cut_left[i].first) {
        cut_left[i] = {lastc + 1, x};
      }
    }
    lastc = not_cut[i - 1].first;
    lastep = not_cut[i - 1].second;
    if (lastep < x - h) {
      if (lastc + 1 > cut_left[i].first) {
        cut_left[i] = {lastc + 1, x};
      }
    }
    lastc = cut_left[i - 1].first;
    lastep = cut_left[i - 1].second;
    if (lastep < x) {
      not_cut[i] = {lastc, x};
    } else {
      not_cut[i] = {0, x};
    }
    lastc = cut_right[i - 1].first;
    lastep = cut_right[i - 1].second;
    if (lastep < x) {
      if (lastc > not_cut[i].first) {
        not_cut[i] = {lastc, x};
      }
    }
    lastc = not_cut[i - 1].first;
    lastep = not_cut[i - 1].second;
    if (lastep < x) {
      if (lastc > cut_left[i].first) {
        cut_left[i] = {lastc, x};
      }
    }
    lastc = cut_left[i - 1].first;
    lastep = cut_left[i - 1].second;
    long nextx = a[i + 1].first;
    if (lastep < x and x + h < nextx) {
      cut_right[i] = {lastc + 1, x + h};
    } else {
      cut_right[i] = {0, x};
    }
    lastc = cut_right[i - 1].first;
    lastep = cut_right[i - 1].second;
    if (lastep < x and x + h < nextx) {
      if (lastc + 1 > cut_right[i].first) {
        cut_right[i] = {lastc + 1, x + h};
      }
    }
    lastc = not_cut[i - 1].first;
    lastep = not_cut[i - 1].second;
    if (lastep < x and x + h < nextx) {
      if (lastc + 1 > cut_right[i].first) {
        cut_right[i] = {lastc + 1, x + h};
      }
    }
  }
  long ans = max(cut_left[n - 1].first,
                 max(cut_right[n - 1].first, not_cut[n - 1].first));
  cout << ans + 1;
  return 0;
}
