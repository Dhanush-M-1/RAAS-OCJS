#include <bits/stdc++.h>
using namespace std;
void input(int* p, int range) {
  for (int i = 0; i < range; i++) {
    int x = 0;
    cin >> x;
    p[i] = x;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n = 0;
  cin >> n;
  int* p1 = new int[n];
  int* p2 = new int[n - 1];
  int* p3 = new int[n - 2];
  input(p1, n);
  input(p2, n - 1);
  input(p3, n - 2);
  sort(p1, p1 + n);
  sort(p2, p2 + n - 1);
  sort(p3, p3 + n - 2);
  int i;
  for (i = 0; i < n - 1; i++) {
    if (p1[i] != p2[i]) {
      break;
    }
  }
  cout << p1[i] << "\n";
  for (i = 0; i < n - 2; i++) {
    if (p2[i] != p3[i]) {
      break;
    }
  }
  cout << p2[i];
  return 0;
}
