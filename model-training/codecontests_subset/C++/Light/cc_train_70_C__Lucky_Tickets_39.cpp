#include <bits/stdc++.h>
using namespace std;
int gcd(int n, int m) {
  if (n == 0) return m;
  return gcd(m % n, n);
}
int reverseNumber(int x) {
  int temp = 0;
  while (x) {
    temp = 10 * temp + (x % 10);
    x /= 10;
  }
  return temp;
}
pair<int, int> getNormalizedCount1(int x) {
  int revX = reverseNumber(x);
  int g = gcd(x, revX);
  return make_pair(x / g, revX / g);
}
pair<int, int> getNormalizedCount2(int x) {
  pair<int, int> pr = getNormalizedCount1(x);
  return make_pair(pr.second, pr.first);
}
int main() {
  int maxX, maxY, w;
  scanf("%d%d%d", &maxX, &maxY, &w);
  map<pair<int, int>, int> count1, count2;
  long long int total = 0;
  for (int i = 1; i <= maxY; ++i) {
    count1[getNormalizedCount1(i)]++;
  }
  int curY = maxY, ans_x, ans_y;
  long long int mx = ((long long int)maxY) * ((long long int)(maxX + 1));
  long long int ans = mx;
  for (int i = 1; i <= maxX; ++i) {
    total += count1[getNormalizedCount2(i)];
    ++count2[getNormalizedCount2(i)];
    while (curY > 0) {
      int temp = count2[getNormalizedCount1(curY)];
      if ((total - temp) < w) break;
      total -= temp;
      --count1[getNormalizedCount1(curY)];
      --curY;
    }
    if (total >= w) {
      long long int cur_ans = ((long long int)i) * ((long long int)curY);
      if (cur_ans < ans) {
        ans = cur_ans;
        ans_x = i;
        ans_y = curY;
      }
    }
  }
  if (ans == mx)
    printf("-1\n");
  else
    printf("%d %d\n", ans_x, ans_y);
  return 0;
}
