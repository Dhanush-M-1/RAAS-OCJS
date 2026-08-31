#include <bits/stdc++.h>

using namespace std;

int N, S[1000001];

int main()
{
  cin >> N;
  for(int i = 0; i < N; i++) {
    int X, Y;
    cin >> X >> Y;
    S[X + Y]++;
  }
  for(int i = 0; i < 1000000; i++) {
    S[i + 1] += S[i] >> 1;
    if(S[i] & 1) cout << i << " " << 0 << endl;
  }
}