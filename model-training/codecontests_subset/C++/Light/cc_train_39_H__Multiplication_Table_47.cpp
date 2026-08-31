#include <bits/stdc++.h>
using namespace std;
int sort(const void* a, const void* b) { return (*(int*)a - *(int*)b); }
int main() {
  int k;
  cin >> k;
  int** mat = new int*[k - 1];
  for (int i = 0; i < k - 1; i++) mat[i] = new int[k - 1];
  for (int i = 0; i < k - 1; i++) mat[0][i] = i + 1;
  for (int i = 1; i < k - 1; i++) mat[i][0] = i + 1;
  for (int i = 1; i < k - 1; i++)
    for (int j = 1; j < k - 1; j++)
      mat[i][j] =
          ((mat[0][j] * mat[i][0]) / k) * 10 + (mat[0][j] * mat[i][0]) % k;
  for (int i = 0; i < k - 1; i++) {
    for (int j = 0; j < k - 1; j++) cout << mat[i][j] << " ";
    cout << endl;
  }
  return 0;
}
