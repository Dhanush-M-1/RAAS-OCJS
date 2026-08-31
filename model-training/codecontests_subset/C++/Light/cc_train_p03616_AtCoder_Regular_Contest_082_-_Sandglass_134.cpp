
#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int x,k;cin>>x>>k;
	vector<int> r(k);
	vector<int> ur(k),dr(k),us(k),ds(k);
	int u=x;
	int d=0;
	int l=-1;
	int exus=0;
	int exds=0;
	int ext=0;
	for(int i=0;i<k;i++){
		cin>>r[i];
		u+=l*(r[i]-ext);
		d+=l*(r[i]-ext);
		if(u>x){
			exus+=u-x;
			u=x;
		}
		if(u<0){
			u=0;
		}
		if(d<0){
			exds+=-d;
			d=0;
		}
		if(d>x){
			d=x;
		}
		ur[i]=u;
		dr[i]=d;
		us[i]=exus;
		ds[i]=exds;
		ext=r[i];
		l*=-1;
	}
//	for(int i=0;i<k;i++){
//		cout<<ur[i]<<' '<<dr[i]<<' '<<us[i]<<' '<<ds[i]<<endl;
//	}
	int q;cin>>q;
	for(int i=0;i<q;i++){
		int t,a;cin>>t>>a;
		int j=upper_bound(r.begin(),r.end(),t)-r.begin();
		int extime,s;
		extime=0;
		s=a;
		if(j){
			extime=r[j-1];
			s=dr[j-1]-ds[j-1]+a;
			if(s<dr[j-1])s=dr[j-1];
			if(s>ur[j-1])s=ur[j-1];
			if(ur[j-1]==dr[j-1])s=ur[j-1];
		}
		s+=((j%2)*2-1)*(t-extime);
		if(s>x)s=x;
		if(s<0)s=0;
		cout<<s<<endl;

	}
	return 0;
}