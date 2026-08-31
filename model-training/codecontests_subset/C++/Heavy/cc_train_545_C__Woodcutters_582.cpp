#include <bits/stdc++.h>
using namespace std;
int n;
int ultIzq, ultDer;
pair<int, int> arr[400005];
int cont = 0;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &arr[i].first, &arr[i].second);
  }
  cont = 2;
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  } else if (n == 2) {
    cout << 2 << endl;
    return 0;
  } else {
    ultIzq = arr[0].first;
    ultDer = arr[n - 1].first;
    for (int i = 1; i < n - 1; i++) {
      if (arr[i].first - arr[i].second > ultIzq) {
        cont++;
        ultIzq = arr[i].first;
      } else {
        if (arr[i].first + arr[i].second < arr[i + 1].first) {
          cont++;
          ultIzq = arr[i].first + arr[i].second;
        } else {
          ultIzq = arr[i].first;
        }
      }
    }
  }
  cout << cont << endl;
  return 0;
}
