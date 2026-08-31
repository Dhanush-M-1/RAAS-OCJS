#include <bits/stdc++.h>

using namespace std;

int main()
{
  int Q;
  cin >> Q;
  while(Q--){
    int N;
    cin >> N;
    for(int i = 0; i <= 1000000; i++){
      if(N / 10 == 0){
	cout << i << endl;
	break;
      } else if(i == 1000000){
	cout << -1 << endl;
	break;
      }
      int fore, back;
      int next = -1;
      for(int j = 10; j <= N; j *= 10){
	fore = N / j;
	back = N % j;
	next = max(next, fore*back);
      }
      N = next;
    }
  }
  return 0;
}