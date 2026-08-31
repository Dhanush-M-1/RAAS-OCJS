#include <iostream>
using namespace std;
#define rep2(x,from,to) for(int x=(from);x<(to);++(x))
#define rep(x,to) rep2(x,0,to)
int main(){
	int n;
	while(cin >> n, n) {
		int a[110] = {}, cnt = 0;
		rep(i,n) {
			cin >> a[i];
		}
		rep(i,n-1) {
			rep(j,n-i-1) {
				if(a[j] > a[j+1]) {
					swap(a[j],a[j+1]);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}
    return 0;
}