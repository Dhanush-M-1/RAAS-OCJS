#include <bits/stdc++.h>
using namespace std;
pair<int, int> p[100005];
int a[100005];
int b[100005];
int main() {
  int n;
  cin >> n;
  int i;
  int count = 0;
  int xm, xp;
  for (i = 0; i < n; i++) {
    scanf("%d %d", &p[i].first, &p[i].second);
    a[i] = p[i].first - p[i].second;
    b[i] = p[i].first + p[i].second;
  }
  for (i = 1; i < n - 1; i++) {
    if (p[i - 1].first < a[i]) {
      count++;
    } else if (p[i + 1].first > b[i]) {
      count++;
      p[i].first = b[i];
    }
  }
  if (n > 2)
    count += 2;
  else
    count += n;
  cout << count;
  return 0;
}
