#include <iostream>
using namespace std;


int ketasuu(int n) {
  int ans = 0;
  while(n > 0){
    ans++;
	n = n / 10;
  }
  return ans;
}

int A[7] = {1,10,100,1000,10000,100000,1000000};
int solve_loop(int n) {
  int a1, a2;
  int ans = 0;
  int k = ketasuu(n);
  if(k == 1 || k == 0) return -1;
  for(int i = 1; i < k; i++) {
    a1 = n / A[i];
	a2 = n % A[i];
	ans = max(ans,a1*a2);
  }
  return ans;
}
int solve(int num) {
  int output = 0;
  while(solve_loop(num) != -1){
    output++;
	num = solve_loop(num);
  }
  return output;
}


int main() {
  int Q, N;
  cin >> Q;
  for(int i = 0; i < Q; i++) {
    cin >> N;
	cout << solve(N) << endl;
  }
}

