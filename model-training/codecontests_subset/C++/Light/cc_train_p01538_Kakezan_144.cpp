#include<iostream>
#include<algorithm>
using namespace std;

int main(){
	int q;
	cin >> q;

	for(int p=0; p < q; p++){
		int num;
		int count = 0;
		cin >> num;

		while(num / 10 != 0){
			int n, m, maxNum = 0;
			for(int d = 10; num / d != 0; d *= 10){
				maxNum = max(maxNum, (num/d) * (num % d));
			}
			num = maxNum;
			count++;
		}
		cout << count << endl;
	}
}