#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#define lol(i,n) for(int i=0;i<n;i++)
#define mod 1000000007
typedef long long ll;
using namespace std;
int x,k,r[100010],q,a,t;
int main(){
	cin>>x>>k;
	r[0]=0;
	lol(i,k)cin>>r[i+1];
	cin>>q;
	int pnt=1;
	int left=0,right=x,nowleft=0,nowright=x;
	while(q--){
		cin>>t>>a;
		while(pnt<=k){
			if(r[pnt]>t)break;
			int move;
			if(pnt%2==0)move=+(r[pnt]-r[pnt-1]);
			if(pnt%2==1)move=-(r[pnt]-r[pnt-1]);
			nowleft+=move,nowright+=move;
			right-=max(0,nowright-x);
			left+=max(0,0-nowleft);
			if(left>right)left=right;
			nowleft=max(0,nowleft);
			nowleft=min(x,nowleft);
			nowright=max(0,nowright);
			nowright=min(x,nowright);
			//cout<<r[pnt]<<"#"<<pnt<<" "<<left<<" "<<right<<" "<<nowleft<<" "<<nowright<<endl;
			pnt++;
		}
		int lastref;
		if(a<=left)lastref=nowleft;
		if(left<a&&a<right)lastref=nowleft+a-left;
		if(right<=a)lastref=nowright;
		if(pnt%2==0)lastref+=(t-r[pnt-1]);
		if(pnt%2==1)lastref-=(t-r[pnt-1]);
		lastref=max(0,lastref);
		lastref=min(x,lastref);
		//cout<<"%"<<left<<" "<<right<<" "<<a<<" "<<nowleft<<" "<<nowright<<endl;
		cout<<lastref<<endl;
	}
	return 0;
}
