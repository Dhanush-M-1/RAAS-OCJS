#include <iostream>
#include <map>
#include <algorithm>
using namespace std;
//http://hadrori.hateblo.jp/entry/aoj2424
//10の累乗で割った余りと商を掛けて次の数にするだけ。

int main(){
	int q;
	for(cin>>q;q;q--){
		int n;
		cin>>n;
		int t=n;
		int cnt=0;
		while(t/10>0){
			int d=10;
			int mx=0;
			while(t/d>0){
				mx=max(mx,(t/d)*(t%d));
				d*=10;
			}
			t=mx;
			if(t==n){
				cnt=n;
				break;
			}
			cnt++;
		}
		cout<<cnt<<endl;
		
	}
	
	return 0;
}
