 #include <bits/stdc++.h>
                                        #include<iostream>
                                        #include<cstdio>
                                        #include<vector>
                                        #include<queue>
                                        #include<map>
                                        #include<cstring>
                                        #include<string>
                                        #include <math.h>
                                        #include<algorithm>
                                    //    #include <boost/multiprecision/cpp_int.hpp>
                                        #include<functional>
                               #define int long long
                                        #define inf  1000000007
                                        #define pa pair<int,int>
                                        #define ll long long
                                        #define pal pair<double,double>
                                        #define ppap pair<pa,int>
                                  
                                        #define ssa pair<string,int>
                                        #define  mp make_pair
                                        #define  pb push_back
                                        #define EPS (1e-10)
                                        #define equals(a,b) (fabs((a)-(b))<EPS)
int dx[4]={0,-1,0,1};
int dy[4]={1,0,-1,0};
                                        using namespace std;
                               			class pa3{
                                        	public:
                                        	int x,y,z;
                                        	pa3(int x=0,int y=0,int z=0):x(x),y(y),z(z) {}
                                        	bool operator < (const pa3 &p) const{
                                        		if(x!=p.x) return x<p.x;
                                        		if(y!=p.y) return y<p.y;
                                        		 return z<p.z;
                                        		//return x != p.x ? x<p.x: y<p.y;
                                        	}
                               				bool operator > (const pa3 &p) const{
                                        		if(x!=p.x) return x>p.x;
                                        		if(y!=p.y) return y>p.y;
                                        		 return z>p.z;
                                        		//return x != p.x ? x<p.x: y<p.y;
                                        	}
                                        	bool operator == (const pa3 &p) const{
                                        		return x==p.x && y==p.y && z==p.z;
                                        	}
                                        		bool operator != (const pa3 &p) const{
                                        			return !( x==p.x && y==p.y && z==p.z);
                                        	}
                                        
                                        };
                                        
                                        class pa4{
                                        	public:
                                        	double x;
                                        	int y,z,w;
                                        	pa4(double x=0,int y=0,int z=0,int w=0):x(x),y(y),z(z),w(w) {}
                                        	bool operator < (const pa4 &p) const{
                                        		if(x!=p.x) return x<p.x;
                                        		if(y!=p.y) return y<p.y;
                                        		if(z!=p.z)return z<p.z;
                                        		return w<p.w;
                                        		//return x != p.x ? x<p.x: y<p.y;
                                        	}
                                        	bool operator > (const pa4 &p) const{
                                        		if(x!=p.x) return x>p.x;
                                        		if(y!=p.y) return y>p.y;
                                        		if(z!=p.z)return z>p.z;
                                        		return w>p.w;
                                        		//return x != p.x ? x<p.x: y<p.y;
                                        	}
                                        	bool operator == (const pa4 &p) const{
                                        		return x==p.x && y==p.y && z==p.z &&w==p.w;
                                        	}
                                        		
                                        
                                        };
                                        class pa2{
                                        	public:
                                        	int x,y;
                                        	pa2(int x=0,int y=0):x(x),y(y) {}
                                        	pa2 operator + (pa2 p) {return pa2(x+p.x,y+p.y);}
                                        	pa2 operator - (pa2 p) {return pa2(x-p.x,y-p.y);}
                                        	bool operator < (const pa2 &p) const{
                                        		return x != p.x ? x<p.x: y<p.y;
                                        	}
                                        	bool operator > (const pa2 &p) const{
                                        		return x != p.x ? x>p.x: y>p.y;
                                        	}
                                        	bool operator == (const pa2 &p) const{
                                        		return abs(x-p.x)==0 && abs(y-p.y)==0;
                                        	}
                                        	bool operator != (const pa2 &p) const{
                                        		return !(abs(x-p.x)==0 && abs(y-p.y)==0);
                                        	}
                                        		
                                        
                                        };
                                        
                                               #define ppa pair<int,pas>
                                        class Point{
                                        	public:
                                        	double x,y;
                                        	Point(double x=0,double y=0):x(x),y(y) {}
                                        	Point operator + (Point p) {return Point(x+p.x,y+p.y);}
                                        	Point operator - (Point p) {return Point(x-p.x,y-p.y);}
                                        	Point operator * (double a) {return Point(x*a,y*a);}
                                        	Point operator / (double a) {return Point(x/a,y/a);}
                                        	double absv() {return sqrt(norm());}
                                        	double norm() {return x*x+y*y;}
                                        	bool operator < (const Point &p) const{
                                        		return x != p.x ? x<p.x: y<p.y;
                                        	}
                                        	bool operator == (const Point &p) const{
                                        		return fabs(x-p.x)<EPS && fabs(y-p.y)<EPS;
                                        	}
                                        };
                                        typedef Point Vector;
                                 #define pl pair<int,pas>
                                        struct Segment{
                                        Point p1,p2;
                                        };
                                         double dot(Vector a,Vector b){
                                        	return a.x*b.x+a.y*b.y;
                                        }
                                        double cross(Vector a,Vector b){
                                        	return a.x*b.y-a.y*b.x;
                                        }
                                    
            bool parareru(Point a,Point b,Point c,Point d){
            //	if(abs(cross(a-b,d-c))<EPS)cout<<"dd "<<cross(a-b,d-c)<<endl;
            	return abs(cross(a-b,d-c))<EPS;
            }
            double distance_ls_p(Point a, Point b, Point c) {
              if ( dot(b-a, c-a) < EPS ) return (c-a).absv();
              if ( dot(a-b, c-b) < EPS ) return (c-b).absv();
              return abs(cross(b-a, c-a)) / (b-a).absv();
            }
            bool is_intersected_ls(Segment a,Segment b) {
            	if(a.p1==b.p1||a.p2==b.p1||a.p1==b.p2||a.p2==b.p2) return false;
            	if(parareru((a.p2),(a.p1),(a.p1),(b.p2))&&parareru((a.p2),(a.p1),(a.p1),(b.p1))){
            //		cout<<"sss"<<endl;
            		if(dot(a.p1-b.p1,a.p1-b.p2)<EPS) return true;
            		if(dot(a.p2-b.p1,a.p2-b.p2)<EPS) return true;
            		if(dot(a.p1-b.p1,a.p2-b.p1)<EPS) return true;
            		if(dot(a.p1-b.p2,a.p2-b.p2)<EPS) return true;
            		return false;
            	}
              else return ( cross(a.p2-a.p1, b.p1-a.p1) * cross(a.p2-a.p1, b.p2-a.p1) < EPS ) && ( cross(b.p2-b.p1, a.p1-b.p1) * cross(b.p2-b.p1, a.p2-b.p1) < EPS );
            }
             
            double segment_dis(Segment a,Segment b){
            	if(is_intersected_ls(a,b))return 0;
            	double r=distance_ls_p(a.p1, a.p2, b.p1);
            	r=min(r,distance_ls_p(a.p1, a.p2, b.p2));
            	r=min(r,distance_ls_p(b.p1, b.p2, a.p2));
            	r=min(r,distance_ls_p(b.p1, b.p2, a.p1));
            	return r;
            }
            Point intersection_ls(Segment a, Segment b) {
              Point ba = b.p2-b.p1;
              double d1 = abs(cross(ba, a.p1-b.p1));
              double d2 = abs(cross(ba, a.p2-b.p1));
              double t = d1 / (d1 + d2);
             
              return a.p1 + (a.p2-a.p1) * t;
            }
             
                            string itos( int i ) {
                            ostringstream s ;
                            s << i ;
                            return s.str() ;
                            }
                             
                            int gcd(int v,int b){
                            	if(v>b) return gcd(b,v);
                            	if(v==b) return b;
                            	if(b%v==0) return v;
                            	return gcd(v,b%v);
                            }
             
                            double distans(double x1,double y1,double x2,double y2){
                            	double rr=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
                            	return sqrt(rr);
                            	
                            }
                            
   //         int pr[2000010];
     //       int inv[2000010];
            
            int beki(int wa,int rr,int warukazu){
            	if(rr==0) return 1ll;
            	if(rr==1) return wa%warukazu;
            	if(rr%2==1) return (beki(wa,rr-1,warukazu)*wa)%warukazu;
            	int zx=beki(wa,rr/2,warukazu);
            	return (zx*zx)%warukazu;
            }
            /*
			int comb(int nn,int rr){
				int r=pr[nn]*inv[rr];
				r%=inf;
				r*=inv[nn-rr];
				r%=inf;
				return r;
			}
            
            void gya(int ert){
            	pr[0]=1;
            	for(int i=1;i<ert;i++){
            		pr[i]=(pr[i-1]*i)%inf;
            	}
            	for(int i=0;i<ert;i++) inv[i]=beki(pr[i],inf-2,inf);
            	
            }
             */
			//priority_queue<pa3,vector<pa3>,greater<pa3>> pq;            
             //sort(ve.begin(),ve.end(),greater<int>());
                                     //----------------kokomade tenpure------------
            //vector<double> ans(100000000),ans2(100000000);
bool dp[380][9][7][7][7][7];
bool  sumi[380][9][7][7][7][7];
int n;
vector<int> kanou[9];
int kumo[9]={0};
int day[400];
void junbi(){
	kanou[0].pb(0);
	kanou[0].pb(1);
	kanou[0].pb(2);
	kanou[0].pb(3);
	kanou[0].pb(6);
	
	kanou[1].pb(0);
	kanou[1].pb(1);
	kanou[1].pb(2);
	kanou[1].pb(4);
	kanou[1].pb(7);
	
	kanou[2].pb(0);
	kanou[2].pb(1);
	kanou[2].pb(2);
	kanou[2].pb(5);
	kanou[2].pb(8);
	
	kanou[3].pb(0);
	kanou[3].pb(3);
	kanou[3].pb(4);
	kanou[3].pb(5);
	kanou[3].pb(6);
	
	kanou[4].pb(4);
	kanou[4].pb(1);
	kanou[4].pb(5);
	kanou[4].pb(3);
	kanou[4].pb(7);
	
	kanou[5].pb(8);
	kanou[5].pb(5);
	kanou[5].pb(2);
	kanou[5].pb(3);
	kanou[5].pb(4);
	
	kanou[6].pb(0);
	kanou[6].pb(8);
	kanou[6].pb(7);
	kanou[6].pb(3);
	kanou[6].pb(6);
	
	kanou[7].pb(4);
	kanou[7].pb(1);
	kanou[7].pb(8);
	kanou[7].pb(7);
	kanou[7].pb(6);
	kanou[8].pb(2);
	kanou[8].pb(5);
	kanou[8].pb(8);
	kanou[8].pb(7);
	kanou[8].pb(6);

	
	kumo[0]=0b0000000000110011;
	kumo[1]=0b0000000001100110;
	kumo[2]=0b0000000011001100;
	kumo[3]=0b0000001100110000;
	kumo[4]=0b0000011001100000;
	kumo[5]=0b0000110011000000;
	kumo[6]=0b0011001100000000;
	kumo[7]=0b0110011000000000;
	kumo[8]=0b1100110000000000;
	
}


bool dfs(int d,int pos,int r5,int r6,int r9,int r10){
	if(r5>=7) return false;
	if(r6>=7) return false;
	if(r9>=7) return false;
	if(r10>=7) return false;
	
	if(day[d]& kumo[pos]) return false;
	
	//cout<<d<<" "<<pos<<" "<<r5<<" "<<r6<<" "<<r9<<" "<<r10<<endl;
	if(sumi[d][pos][r5][r6][r9][r10]) return dp[d][pos][r5][r6][r9][r10];
	if(d==n){
	//	cout<<d<<" "<<pos<<endl;
		return true;
	}
	bool bo=false;
	
		
	
	for(auto v:kanou[pos]){
		int l5=r5;
		int l6=r6;
		int l9=r9;
		int l10=r10;
		if((kumo[v]&(1<<0) )==0) l5++;
		else l5=0;
		if((kumo[v]&(1<<3) )==0) l6++;
		else l6=0;
		if((kumo[v]&(1<<12) )==0) l9++;
		else l9=0;
		if((kumo[v]&(1<<15) )==0) l10++;
		else l10=0;
		
		if(dfs(d+1,v,l5,l6,l9,l10)){
			bo=true;
			goto lll;
		}
	}
	lll:;
	sumi[d][pos][r5][r6][r9][r10]=1;
	dp[d][pos][r5][r6][r9][r10]=bo;
	return bo;
}

   signed main(){
   	junbi();
   	
   	
  int a[110][110];
  
   	while(1){
   	cin>>n;
   		if(n==0) return 0;
   		
   		for(int i=0;i<370;i++)for(int k=0;k<9;k++)for(int l1=0;l1<7;l1++)for(int l2=0;l2<7;l2++)for(int l3=0;l3<7;l3++)for(int l4=0;l4<7;l4++){
   		sumi[i][k][l1][l2][l3][l4]=0;
   		}
   		for(int i=1;i<=n;i++){
   			int l=0;
   			for(int j=0;j<16;j++){
   				char c;
   			cin>>c;
   				if(c=='1') l+= 1<<j;
   			}
   			day[i]=l;
   		}
   		
   		if(dfs(1,4,1,1,1,1))cout<<1<<endl;
   		else cout<<0<<endl;
   	}
   	return 0;
        }
