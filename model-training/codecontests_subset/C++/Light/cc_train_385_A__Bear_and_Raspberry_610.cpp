#include <bits/stdc++.h>
using namespace std;
const double PI =
    3.14159265358979323846264338327950288419716939937510582097494459230;
void swaps(char *x, char *y) {
  char temp;
  temp = *x;
  *x = *y;
  *y = temp;
}
void swapi(int *a, int *b) {
  int temp;
  temp = *a;
  *a = *b;
  *b = temp;
}
unsigned long long gcd(unsigned long long a, unsigned long long b) {
  if (a == 0) return b;
  if (b == 0) return a;
  if (a == 1 || b == 1) return 1;
  if (a == b) return a;
  if (a > b)
    return gcd(b, a % b);
  else
    return gcd(a, b % a);
}
int X[101];
int main() {
  int Cases = 1;
  for (int Case = 0; Case < Cases; Case++) {
    int N, Req;
    cin >> N >> Req;
    int Ans = 0;
    for (int i = 0; i < N; i++) cin >> X[i];
    for (int i = 0; i < N - 1; i++) {
      Ans = max(Ans, X[i] - X[i + 1] - Req);
    }
    cout << Ans << endl;
  }
}
