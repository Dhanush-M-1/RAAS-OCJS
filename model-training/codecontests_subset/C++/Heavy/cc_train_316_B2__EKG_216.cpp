#include <bits/stdc++.h>
using namespace std;
int n, x;
int pre[1100];
int net[1100];
bool hah[1100];
vector<int> val;
int main() {
  while (cin >> n >> x) {
    memset(pre, -1, sizeof(pre));
    memset(net, -1, sizeof(net));
    memset(hah, false, sizeof(hah));
    for (int i = 1; i <= n; i++) {
      int a;
      scanf("%d", &a);
      if (a != 0) {
        pre[i] = a;
        net[a] = i;
      }
    }
    val.clear();
    for (int i = 1; i <= n; i++) {
      if (pre[i] == -1) {
        int ct = 0;
        int a = i;
        bool f = true;
        while (a != -1) {
          if (a == x) {
            f = false;
          }
          ct++;
          a = net[a];
        }
        if (f == true) {
          val.push_back(ct);
        }
      }
    }
    sort(val.begin(), val.end());
    hah[0] = true;
    for (int i = 0; i < val.size(); i++) {
      for (int j = n; j >= 0; j--) {
        if (hah[j] == true) {
          hah[j + val[i]] = true;
        }
      }
    }
    int n1 = 0;
    int b = x;
    while (b != -1) {
      n1++;
      b = pre[b];
    }
    for (int i = 0; i <= n; i++) {
      if (hah[i] == true) {
        printf("%d\n", n1 + i);
      }
    }
  }
  return 0;
}
