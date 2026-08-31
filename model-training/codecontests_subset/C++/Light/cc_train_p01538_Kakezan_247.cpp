#include<iostream>
#include<cmath>

using namespace std;

long Q, N;

long multip(long n, long keta){
	long maxn = 0;
	long left ,right;
	for(long i=keta-1;i>=1;i--){
		left = n / pow(10,i);
		right = n - left*pow(10,i);
		long mul = left * right;
		if(mul > maxn) maxn = mul;
	}
	return maxn;
}
		
int getketa(int n){
	int i=0;
	int keta = 1;
	for(i=1;keta>0;i++){
		keta = n / pow(10,i);
	}
	return i-1;
}

int main(){
	cin >> Q;
	for(long i=0;i<Q;i++){
		cin >> N;
		long keta;
		long count = 0;
		while(keta = getketa(N),keta != 1 && count < 10000){
			N = multip(N, keta);
			//cout << N << endl;
			count ++;
		}
		cout << count << endl;
	}
	
	return 0;
}
			