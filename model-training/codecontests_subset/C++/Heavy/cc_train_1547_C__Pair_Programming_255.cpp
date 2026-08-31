#include <bits/stdc++.h>
#include<iostream>
#include<string>
using namespace std;
typedef long long ll;
struct str{
	ll val;
	int ind;
	
};
bool comp(str a, str b){
	return a.val<b.val;
}
void find_ans(vector<int>a,int n){
	
}
bool prime(int n){
	for(int i=2;i<=sqrt(n);i++)
		if(n%i==0)
			return 0;
	return 1;
}
/*vector<int> get_max_seq(int n,vector<int>p){
	
	vector<int>cores;
	for(int i=1;i<n;i++){
		
	}
	cores.push_back(max_seq);
	return cores;
}*/
bool check(int n,vector<int>p,int pos,int max_seq,vector<int>cores){
	int bordier=0;
	while(true){
		bordier++;
		if(pos-bordier<0 || pos+bordier>=n || p[pos-bordier]>p[pos-bordier+1] || p[pos+bordier]>p[pos+bordier-1])
			break;
		
	}
	bordier--;
	//cout<<endl<<pos<<' '<< bordier<<endl;
	if(bordier%2!=0 || bordier<max_seq)
		return 0;
	if(bordier==max_seq){
		for(int i=0;i<cores.size();i++)
			if(cores[i]>pos || cores[i]<pos-bordier)
				return 0;
	}
	return 1;
}
int main(){
	/*setlocale(LC_ALL, "Russian");,*/
	//ifstream myfile("in.txt");
	//ofstream outfile("out.txt");
	//map<pair<int,int>,int>pairs;
	int t;
	cin>>t;
	for(int test=1;test<=t;test++){
		int k,n,m;
		bool correct=1;
		cin>>k>>n>>m;
		vector<int>a(n);
		vector<int>b(m);
		vector<int>ans(n+m);
		int zeros=0,pos=0;
		for(int i=0;i<n;i++)
			cin>>a[i];
		for(int i=0;i<m;i++)
			cin>>b[i];
		int posa=0,posb=0;
		while(pos<n+m){
			if(posa<n && a[posa]==0){
				ans[pos]=0;
				k++;
				pos++;
				posa++;
				continue;
			}else if(posb<m && b[posb]==0){
				ans[pos]=0;
				k++;
				pos++;
				posb++;
				continue;
			}else if(posa<n && a[posa]<=k){
				ans[pos]=a[posa];
				pos++;
				posa++;
				continue;
			}else if(posb<m && b[posb]<=k){
				ans[pos]=b[posb];
				pos++;
				posb++;
				continue;
			}else{
				correct=0;
				break;
			}
	}
	if(!correct){
			printf("-1\n");
		}else{
			for(int i=0;i<n+m;i++)
				printf("%d ",ans[i]);
				printf("\n");
		}
	}
	return 0;
}









