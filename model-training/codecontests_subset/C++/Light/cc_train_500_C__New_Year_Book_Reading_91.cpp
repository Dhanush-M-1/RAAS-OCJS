#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  while (cin >> a >> b) {
    int A[1204] = {};
    for (int i = 1; i <= a; i++) {
      cin >> A[i];
    }
    int B[1024] = {};
    for (int i = 1; i <= b; i++) {
      cin >> B[i];
    }
    int vis[1024] = {};
    vector<int> num;
    for (int i = 1; i <= b; i++) {
      if (!vis[B[i]]) {
        vis[B[i]] = 1;
        num.push_back(B[i]);
      }
    }
    int ans = 0;
    for (int i = 1; i <= b; i++) {
      int sum = 0;
      for (int j = 0; j < num.size(); j++) {
        int k = num[j];
        if (k == B[i]) {
          ans += sum;
          num.erase(num.begin() + j);
          num.insert(num.begin(), B[i]);
          break;
        }
        sum += A[k];
      }
    }
    cout << ans << '\n';
  }
  return 0;
}
