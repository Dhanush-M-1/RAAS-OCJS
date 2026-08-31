#include <iostream>
#include <algorithm>

using namespace std;

int X, K;
int r[100005];
int Q;

int lb[100005], ub[100005];
int sum[100005], Max[100005], Min[100005];

int main(void)
{
	cin >> X >> K;
	for(int i = 1; i <= K; i++) cin >> r[i];
	
	for(int i = 1; i <= K; i++){
		if(i % 2) sum[i] = sum[i-1] - (r[i] - r[i-1]);
		else sum[i] = sum[i-1] + (r[i] - r[i-1]);
	}
	
	Max[0] = X, ub[0] = X;
	for(int i = 1; i <= K; i++){
		ub[i] = ub[i-1];
		if(i % 2){
			Max[i] = Max[i-1] - (r[i] - r[i-1]);
			if(Max[i] < 0) Max[i] = 0;
		}
		else{
			Max[i] = Max[i-1] + (r[i] - r[i-1]);
			if(Max[i] > X){
				ub[i] -= Max[i] - X;
				Max[i] = X;
			}
		}
	}
	Min[0] = 0, lb[0] = 0;
	for(int i = 1; i <= K; i++){
		lb[i] = lb[i-1];
		if(i % 2){
			Min[i] = Min[i-1] - (r[i] - r[i-1]);
			if(Min[i] < 0){
				lb[i] += -Min[i];
				Min[i] = 0;
			}
		}
		else{
			Min[i] = Min[i-1] + (r[i] - r[i-1]);
			if(Min[i] > X) Min[i] = X;
		}
	}
	
	cin >> Q;
	int t, a, pos, val;
	for(int q = 0; q < Q; q++){
		cin >> t >> a;
		pos = upper_bound(r, r+K+1, t) - r-1;
		if(a <= lb[pos]) val = Min[pos];
		else if(a >= ub[pos]) val = Max[pos];
		else val = a + sum[pos];
		if(pos % 2){
			val += t - r[pos];
			val = min(val, X);
		}
		else{
			val -= t - r[pos];
			val = max(val, 0);
		}
		cout << val << endl;
	}
	
	return 0;
}