#include <bits/stdc++.h>
using namespace std;
vector<int> H, X;
int n;
long long DP[100005][2];
long long solve(int i, bool F) {
  long long &ret = DP[i][F];
  if (ret != -1) return ret;
  if (i == n - 1) return 0;
  long long F2 = 0, choice1 = 0, choice2 = 0, choice3 = 0, choice4 = 0;
  if (((X[i] - X[i - 1] - 1) >= H[i]) && F == true)
    choice1 += solve(i + 1, true) + 1, F2 = 1;
  if ((X[i + 1] - X[i] - 1) >= H[i]) choice2 += solve(i + 1, false) + 1, F2 = 1;
  if (X[i] - H[i] > X[i - 1] + H[i - 1])
    choice4 += solve(i + 1, true) + 1, F2 = 1;
  if (F2 == 0) choice3 += solve(i + 1, true);
  ret = max(choice1, max(choice2, max(choice3, choice4)));
  return ret;
}
int main() {
  memset(DP, -1, sizeof DP);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    X.push_back(a);
    H.push_back(b);
  }
  if (X.size() > 1)
    printf("%I64d", solve(1, true) + 2);
  else
    printf("1");
}
