#include <stdio.h>
#include <iostream>
#include <vector>
#include <list>
#include <cmath>
#include <fstream>
#include <algorithm>
#include <string>
#include <queue>
#include <set>
#include <map>
#include <complex>
#include <iterator>
#include <cstdlib>
#include <cstring>
#include <sstream>

using namespace std;

#define EPS (1e-10)
#define EQ(a,b) (abs((a) - (b)) < EPS)
#define EQV(a,b) (EQ((a).real(),(b).real()) && EQ((a).imag(),(b).imag()))

typedef complex<double> P;
typedef long long ll;

const int MAX_SIZE = 10000;

int main(){

	int n;
	while(cin>>n&&n!=0){

	int a[101];
	for(int i = 0; i < n; i++){
		cin>>a[i];
	}

	int cnt=0;
	for(int j = n-1; j >= 1; j--){
		for(int i = 0; i < j; i++){
			if(a[i]>a[i+1]){
				swap(a[i],a[i+1]);
				cnt++;
			}
		}
	}
	cout<<cnt<<endl;
	}

	return 0;
}