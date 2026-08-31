#include <bits/stdc++.h>
using namespace std;
int following[1005];
int queueLength[1005];
int okQueue[1005];
int main() {
  int n, k;
  cin >> n >> k;
  int head = k, shift = 1, tmp;
  for (int i = 1; i <= n; i++) {
    cin >> following[i];
    queueLength[i]++;
    tmp = i;
    while (following[tmp] != 0) {
      queueLength[following[tmp]] += queueLength[i];
      tmp = following[tmp];
    }
  }
  while (following[head]) {
    head = following[head];
    shift++;
  }
  vector<int> queues;
  for (int i = 1; i <= n; i++) {
    if (following[i] == 0 && i != head) {
      queues.push_back(queueLength[i]);
    }
  }
  sort(queues.begin(), queues.end());
  okQueue[0] = 1;
  for (unsigned i = 0; i < queues.size(); i++) {
    for (int j = n - queues[i]; j >= 0; j--) {
      if (okQueue[j]) {
        okQueue[j + queues[i]] = 1;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    if (okQueue[i]) printf("%d\n", i + shift);
  }
  return 0;
}
