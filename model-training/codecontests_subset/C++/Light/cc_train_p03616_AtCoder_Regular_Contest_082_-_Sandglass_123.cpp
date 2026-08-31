#include <iostream>
#include <algorithm>
using namespace std;
long long u[100010],d[100010],r[100010],mn[100010],mx[100010];
int main(){
	long long i,j,x,k,q,t,a,l;
	cin >> x >> k;
	for(i=1;i<=k;i++){
		cin >> r[i];
	}
	r[0] = 0;
	//前処理
	u[0] = 0; d[0] = x; mn[0] = 0; mx[0] = x;
	for(i=1;i<=k;i++){
		long long y = r[i]-r[i-1],k;
		if(i%2==1){
			mx[i] = max(mx[i-1]-y,(long long)0);
			mn[i] = max(mn[i-1]-y,(long long)0);
			u[i] = u[i-1]+mn[i]-(mn[i-1]-y);
			d[i] = d[i-1];
		}else{
			mx[i] = min(mx[i-1]+y,x);
			mn[i] = min(mn[i-1]+y,x);
			u[i] = u[i-1];
			d[i] = d[i-1]-(mx[i-1]+y-mx[i]);
		}
	}
		
	cin >> q;
	l = 0;
	for(j=0;j<q;j++){
		cin >> t >> a;
		for(i=l;i<=k;i++){
			if(r[i]>t){
				l = i-1;
				break;
			}
			if(i==k){
				l = i;
			}
		}
		if(u[l]>=d[l]){
			if(l%2==0){
				cout << max(mn[l]-t+r[l],(long long)0) << endl;
			}else{
				cout << min(mn[l]+t-r[l],x) << endl;
			}
		}else{
			if(a<=u[l]){
				if(l%2==0){
					cout << max(mn[l] - t + r[l],(long long)0) << endl;
				}else{
					cout << min(mn[l] + t - r[l],x) << endl;
				}
			}else if(a>=d[l]){
				if(l%2==0){
					cout << max(mx[l] - t + r[l],(long long)0) << endl;
				}else{
					cout << min(mx[l] + t - r[l],x) << endl;
				}
			}else{
				if(l%2==0){
					cout << max(mx[l]-(d[l]-a)-t+r[l],(long long)0) << endl;
				}else{
					cout << min(mx[l]-(d[l]-a)+t-r[l],x) << endl;
				}
			}
		}
	}
}