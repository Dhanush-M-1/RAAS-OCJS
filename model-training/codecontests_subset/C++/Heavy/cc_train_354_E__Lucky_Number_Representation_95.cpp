#include <bits/stdc++.h>
using namespace std;
const int MAX = 44;
const int L[] = {0, 4, 7};
vector<int> digits[10];
vector<int> numbers[MAX];
void generate(int a[], int d, int k) {
  if (d == 6) {
    int sum = 0;
    for (int i = 0; i < 6; i++) {
      sum += a[i];
    }
    if (numbers[sum].empty()) {
      numbers[sum] = vector<int>(a, a + 6);
    }
    digits[sum % 10].push_back(sum);
  } else {
    for (int i = k; i < 3; i++) {
      a[d] = L[i];
      generate(a, d + 1, i);
    }
  }
}
long long result[6];
bool find(long long n) {
  if (n < 0) {
    return false;
  } else if (n == 0) {
    return true;
  } else {
    for (int i = 0; i < digits[n % 10].size(); i++) {
      int nr = digits[n % 10][i];
      if (find((n - nr) / 10)) {
        for (int j = 0; j < 6; j++) {
          result[j] = result[j] * 10 + numbers[nr][j];
        }
        return true;
      }
    }
    return false;
  }
}
int main() {
  ios::sync_with_stdio(false);
  int a[6];
  generate(a, 0, 0);
  int k;
  cin >> k;
  for (int i = 0; i < k; i++) {
    memset(result, 0, 6 * sizeof(long long));
    long long n;
    cin >> n;
    if (find(n)) {
      for (int j = 0; j < 6; j++) {
        cout << result[j] << ' ';
      }
      cout << endl;
    } else {
      cout << -1 << endl;
    }
  }
  return 0;
}
