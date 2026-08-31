#include<iostream>
using namespace std;

int main() {
  int DIV = 1e+9 + 7;
  int N, M; cin >> N >> M;
  int A[N]; for (int i = 0; i < N; i++) cin >> A[i];
  bool s[N]; for (int i = 0; i < N; i++) s[i] = true;
  for (int i = 0; i < M; i++) s[A[i]-1] = false;
  long d[N+1]; d[0] = 1; d[1] = s[0];
  for (int i = 2; i <= N; i++) d[i] = s[i-1] * (d[i-1] + d[i-2]) % DIV;
  cout << d[N] << endl;
}