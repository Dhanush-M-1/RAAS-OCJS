#include <bits/stdc++.h>
using namespace std;
const int N = 0;
int n, k, x, t;
string s;
vector<pair<int, int>> v;
int main() {
  scanf("%d", &n);
  for (int i = 0, a, b; i < n; i++) {
    scanf("%d%d", &a, &b);
    v.push_back({a, b});
  }
  int prevL = v[0].first;
  int stay[100005], left[100005], right[100005];
  memset(stay, 0, sizeof stay);
  memset(left, 0, sizeof left);
  memset(right, 0, sizeof right);
  for (int i = 1; i < n - 1; i++) {
    stay[i] = right[i] = max(left[i - 1], max(stay[i - 1], right[i - 1]));
    if (v[i].first - v[i].second <= v[i - 1].first) {
      left[i] = stay[i];
    } else {
      if (v[i].first - v[i].second > v[i - 1].first + v[i - 1].second)
        left[i] = stay[i] + 1;
      else
        left[i] = max(left[i - 1], stay[i - 1]) + 1;
    }
    if (v[i].first + v[i].second < v[i + 1].first) {
      right[i]++;
    }
  }
  if (n == 1) {
    printf("1\n");
  } else
    printf("%d\n", max(left[n - 2], max(right[n - 2], stay[n - 2])) + 2);
  return 0;
}
