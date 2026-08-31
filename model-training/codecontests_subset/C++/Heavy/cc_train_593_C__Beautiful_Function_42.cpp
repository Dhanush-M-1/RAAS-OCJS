#include <bits/stdc++.h>
template <class T>
void print_arr(T* arr, int n) {
  for (int i = 0; i < n; ++i) std::cout << arr[i] << ' ';
  std::cout << std::endl;
}
const double EPS = 1e-6;
using namespace std;
void process(int caseNum) {}
int main() {
  int n;
  cin >> n;
  if (n == 1) {
    int x, y;
    cin >> x >> y;
    cout << x << endl << y << endl;
  } else {
    int xarr[57], yarr[57];
    int r;
    for (int i = 0; i < (n); ++i) cin >> xarr[i] >> yarr[i] >> r;
    cout << string(n - 1, '(');
    printf("(%d*((1-t)+abs((1-t))))", xarr[0] / 2);
    for (int i = 1; i < n; ++i) {
      printf(
          "+(((((%d-t)+abs((%d-t)))-((%d-t)+abs((%d-t))))-(((%d-t)+abs((%d-t)))"
          "-((%d-t)+abs((%d-t)))))*%d))",
          i + 1, i + 1, i, i, i, i, i - 1, i - 1, xarr[i] / 2);
    }
    cout << endl;
    cout << string(n - 1, '(');
    printf("(%d*((1-t)+abs((1-t))))", yarr[0] / 2);
    for (int i = 1; i < n; ++i) {
      printf(
          "+(((((%d-t)+abs((%d-t)))-((%d-t)+abs((%d-t))))-(((%d-t)+abs((%d-t)))"
          "-((%d-t)+abs((%d-t)))))*%d))",
          i + 1, i + 1, i, i, i, i, i - 1, i - 1, yarr[i] / 2);
    }
    cout << endl;
  }
  return 0;
}
