#include <bits/stdc++.h>
using namespace std;
list<int> order;
int B[1550] = {0};
int BUCK[1550] = {0};
int W[1550];
int N, M;
int main() {
  scanf("%d %d", &N, &M);
  for (int i = 1; i <= N; i++) scanf("%d", &W[i]);
  for (int i = 1; i <= M; i++) {
    scanf("%d", &B[i]);
    if (BUCK[B[i]] == 0) {
      BUCK[B[i]] = 1;
      order.push_back(B[i]);
    }
  }
  long long sum = 0;
  for (int i = 1; i <= M; i++) {
    auto it = order.begin();
    for (; *it != B[i]; ++it) sum += W[*it];
    order.erase(it);
    order.push_front(B[i]);
  }
  printf("%I64d", sum);
}
