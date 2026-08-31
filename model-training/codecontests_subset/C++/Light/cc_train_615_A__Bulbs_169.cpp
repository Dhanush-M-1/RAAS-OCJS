#include <bits/stdc++.h>
using namespace std;
const int maxn = 0;
int main() {
  int button, light;
  int arr[105];
  for (int i = 0; i < 105; i++) {
    arr[i] = 0;
  }
  cin >> button >> light;
  for (int i = 0; i < button; i++) {
    int x;
    cin >> x;
    for (int i = 0; i < x; i++) {
      int y;
      cin >> y;
      arr[y - 1]++;
    }
  }
  bool flag = true;
  for (int i = 0; i < light; i++) {
    if (arr[i] == 0) {
      flag = false;
    }
  }
  if (flag)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
