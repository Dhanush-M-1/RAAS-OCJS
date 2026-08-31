#include <iostream>
using namespace std;


int n,a[3400010] = {};
int main(){
	cin >> n;
	for(int i = 0;i < n;i++){
		int A,b;
		cin >> A >> b;
		a[A + b]++;
	}
	for(int i = 0;i <= 3400000;i++){
		if(a[i] % 2) cout << i << " " << 0 << endl;
		a[i + 1] += a[i] / 2;
	}
	return 0;
}