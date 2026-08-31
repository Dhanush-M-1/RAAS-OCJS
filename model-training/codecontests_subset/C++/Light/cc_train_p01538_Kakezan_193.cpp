#include<iostream>
#include<cmath>
#include<set>

using namespace std;

int main(){

	long long Q,N,M;
	long long max;
	int cnt;
	set<long long> inf;

	cin>>Q;

	while(Q--){

		cin>>N;

		if(!inf.empty()) inf.clear();

		cnt=0;
		while(N/10!=0){
			M=0;
			max=-1;
			for(int i=0;N!=0;i++){
				M+=N%10*pow(10.0,i);
				N/=10;
				if(M*N>max) max=N*M;
			}
			if(inf.find(max)!=inf.end()){
				cnt=-1;
				break;
			}
			inf.insert(max);
			N=max;
			cnt++;
		}

		cout<<cnt<<endl;

	}
}